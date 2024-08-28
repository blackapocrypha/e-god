<template>
  <div class="greetings">
    <h1 class="green">{{ msg }}</h1>

    <el-form :model="form" label-width="auto" style="max-width: 600px">
      <el-form-item label="日期：">
        <el-date-picker v-model="form.birth" type="datetime" placeholder="请选择出生日期" />
      </el-form-item>
      <el-form-item label="性别：">
        <el-radio-group v-model="form.gender">
          <el-radio value="1">男</el-radio>
          <el-radio value="0">女</el-radio>
        </el-radio-group>
      </el-form-item>

      <el-form-item label="操作：">
        <el-button size="large" type="success" style="float: right" @click="subForm"
          >排盘</el-button
        >
      </el-form-item>
    </el-form>
  </div>
</template>

<script setup lang="ts">
import { reactive } from 'vue'
import { useInfoStore } from '@/stores/info'
import type { userInfo } from '@/api/eight/type'
import { useRouter } from 'vue-router'
const info = useInfoStore()
const route = useRouter()

let form = reactive<userInfo>({
  birth: new Date(),
  gender: '1'
})

const subForm = () => {
  info.setBirth(form.birth)
  info.setGender(form.gender)
  console.log('更换日期：' + info.birth)
  route.push({
    path: '/yearEight',
    replace: true
  })
}

defineProps<{
  msg: string
}>()
</script>

<style scoped>
h1 {
  font-weight: 500;
  font-size: 2.6rem;
  position: relative;
  top: -10px;
}

h3 {
  font-size: 1.2rem;
}

.greetings h1,
.greetings h3 {
  text-align: center;
}

@media (min-width: 1024px) {
  .greetings h1,
  .greetings h3 {
    text-align: left;
  }
}
</style>
