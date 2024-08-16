import { ref } from 'vue'
import { defineStore } from 'pinia'

export const useInfoStore = defineStore('info', () => {
  const gender = ref(1)
  const birth = ref(new Date())

  function setBirth(data: any) {
    birth.value = data
  }
  function setGender(data: number) {
    gender.value = data
  }

  return { gender, birth, setBirth, setGender }
})
