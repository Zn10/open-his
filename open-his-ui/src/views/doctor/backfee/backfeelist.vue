<template>
  <div class="app-container">
    <!-- 查询条件开始 -->
    <el-form ref="queryForm" :model="queryParams" :inline="true" label-width="98px">
      <el-form-item label="患者姓名" prop="patientName">
        <el-input
          v-model="queryParams.patientName"
          placeholder="请输入患者姓名"
          clearable
          size="small"
          style="width:240px"
        />
      </el-form-item>
      <el-form-item label="挂号单号" prop="regId">
        <el-input
          v-model="queryParams.regId"
          placeholder="请输入挂号单号"
          clearable
          size="small"
          style="width:240px"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button type="primary" icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>
    <!-- 数据表格开始 -->
    <el-table v-loading="loading" border :data="orderBackfeeTableList">
      <el-table-column label="退费订单号" align="center" width="210" prop="orderId" />
      <el-table-column label="挂号单号" align="center" width="200" prop="regId" />
      <el-table-column label="患者姓名" align="center" prop="patientName" />
      <el-table-column label="总金额" align="center" prop="backAmount" />
      <el-table-column label="退费类型" align="center" prop="backType" :formatter="backTypeFormatter" />
      <el-table-column label="订单状态" prop="orderStatus" align="center" :formatter="backStatusFormatter" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="操作" width="300px" align="center">
        <template slot-scope="scope">
          <el-button type="text" icon="el-icon-view" size="mini" @click="handleViewItem(scope.row)">查看详情</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页控件开始 -->
    <el-pagination
      v-show="total>0"
      :current-page="queryParams.pageNum"
      :page-sizes="[5, 10, 20, 30]"
      :page-size="queryParams.pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
    />
    <!-- 分页控件结束 -->
    <!-- 数据表格结束 -->
    <!-- 查看详情的弹出层开始 -->
    <el-dialog
      v-loading="loading"
      :title="title"
      :visible.sync="open"
      width="1000px"
      center
      append-to-body
    >
      <el-table
        v-loading="itemTableloading"
        border
        :data="orderBackfeeItemList"
      >
        <el-table-column label="详情ID" align="center" width="210" prop="itemId" />
        <el-table-column label="处方ID" align="center" width="200" prop="coId" />
        <el-table-column label="名称" align="center" prop="itemName" />
        <el-table-column label="价格" align="center" prop="itemPrice" />
        <el-table-column label="数量" align="center" prop="itemNum" />
        <el-table-column label="小计" prop="itemAmount" align="center" />
        <el-table-column label="类型" align="center" prop="itemType">
          <template slot-scope="scope">
            {{ scope.row.itemType==='0'?'药品':'检查' }}
          </template>
        </el-table-column>
        <el-table-column label="状态" align="center" prop="status" :formatter="statusFormatter" />
      </el-table>
      <span slot="footer" class="dialog-footer">
        <el-button @click="cancel">关 闭</el-button>
      </span>
    </el-dialog>
    <!-- 查看详情的弹出层结束 -->

  </div>
</template>

<script>
import { queryAllOrderBackfeeForPage, queryOrderBackfeeItemByBackId } from '@/api/docter/backfee'
export default {
  data() {
    return {
      // 是否启用遮罩层
      loading: false,
      // 详情表格的遮罩
      itemTableloading: false,
      // 分页数据总条数
      total: 0,
      // 弹出层标题
      title: '',
      // 是否显示支付宝支付的弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        patientName: undefined,
        regId: undefined
      },
      // 数据表格的数据
      orderBackfeeTableList: [],
      // 支付类型字典数据
      backTypeOptions: [],
      // 订单状态字典数据
      backStatusOptions: [],
      // 详情表格的数据
      orderBackfeeItemList: [],
      // 详情状态的数据字典
      statusOptions: []
    }
  },
  created() {
    // 查询支付类型字典数据
    this.getDataByType('his_pay_type_status').then(res => {
      this.backTypeOptions = res.data
    })
    // 订单状态字典数据
    this.getDataByType('his_backfee_status').then(res => {
      this.backStatusOptions = res.data
    })
    // 加载详情状态的字典数据
    this.getDataByType('his_order_details_status').then(res => {
      this.statusOptions = res.data
    })
    // 查询订单数据
    this.listOrderBackfee()
  },
  methods: {
    listOrderBackfee() {
      this.loading = true
      queryAllOrderBackfeeForPage(this.queryParams).then(res => {
        this.orderBackfeeTableList = res.data
        this.total = res.total
        this.loading = false
      }).catch(() => {
        this.msgError('查询失败')
        this.loading = false
      })
    },

    // 条件查询
    handleQuery() {
      this.listOrderBackfee()
    },
    // 重置查询条件
    resetQuery() {
      this.resetForm('queryForm')
      this.listOrderBackfee()
    },
    // 分页pageSize变化时触发
    handleSizeChange(val) {
      this.queryParams.pageSize = val
      // 重新查询
      this.listOrderBackfee()
    },
    // 点击上一页  下一页，跳转到哪一页面时触发
    handleCurrentChange(val) {
      this.queryParams.pageNum = val
      // 重新查询
      this.listOrderBackfee()
    },
    // 支付类型翻译
    backTypeFormatter(row) {
      return this.selectDictLabel(this.backTypeOptions, row.backType)
    },
    // 订单状态翻译
    backStatusFormatter(row) {
      return this.selectDictLabel(this.backStatusOptions, row.backStatus)
    },
    // 订单详情状态翻译
    statusFormatter(row) {
      return this.selectDictLabel(this.statusOptions, row.status)
    },
    // 查看详情
    handleViewItem(row) {
      this.title = '查询【' + row.patientName + '】退费订单详情'
      this.open = true
      this.itemTableloading = true
      queryOrderBackfeeItemByBackId(row.backId).then(res => {
        this.orderBackfeeItemList = res.data
        this.itemTableloading = false
      }).catch(() => {
        this.msgError('查询失败')
        this.itemTableloading = false
      })
    },
    // 关闭查看详情
    cancel() {
      this.open = false
    }
  }
}
</script>
<style scoped>
  .demo-table-expand {
    font-size: 0;
  }
  .demo-table-expand label {
    width: 90px;
    color: #99a9bf;
  }
  .demo-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
  }
</style>
