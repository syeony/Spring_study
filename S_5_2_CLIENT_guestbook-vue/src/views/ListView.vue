<script setup>
import ListDetail from '../components/ListDetail.vue'
import axios from '@/util/http-common';
import { inject, onMounted, onUnmounted, ref } from 'vue';

const users = ref([])
const selectedUserId = ref('')
const modifyUserId = ref('')

const emitter = inject('emitter'); // Inject `emitter`

onMounted(() => {
  selectAll()
  emitter.on("deleteUser", (userid) => {
    deleteUser(userid)
  })
})

onUnmounted(() => {
  emitter.off('deleteUser');
})


function selectAll() {
  axios
  .get('/admin/user')
  .then(({ data }) => {
    // console.log('data',data)
    users.value = data;
  })
  .catch(() => {
    alert('에러가 발생했습니다.');
  });
}
    
function deleteUser(userid) {
  console.log("deleteUser....."+userid)
  let test = confirm("정말로 삭제하시겠습니까?");
  if(test){
    axios
    .delete(`/admin/user/${userid}`)
    .then(() => {
      alert('삭제 성공.!');
      selectAll()
    })
    .catch((e) => {
      alert('에러가 발생했습니다.!!');
      console.log(e)
    });
  }
}

</script>


<template>
  <div>
    <div align="right" class='me-2'>
      <RouterLink :to="`/join`">
        <button type="button" class="btn btn-outline-success">등록</button>
      </RouterLink>
    </div>    
    <div class="m-2">
      <table class='table table-bordered'>
        <colgroup>
          <col width="120">
          <col width="120">
          <col width="120">
          <col width="170">
          <col width="*">
          <col width="120">
          <col width="150">
        </colgroup>
        <thead head-variant="light">
          <tr>
            <th>아이디</th>
            <th>비밀번호</th>
            <th>이름</th>
            <th>이메일</th>
            <th>주소</th>
            <th>가입일</th>
            <th>수정/삭제</th>
          </tr>
        </thead>
        <tbody>
          <ListDetail v-for="(user,index) in users" :key="index" :user="user"></ListDetail>
        </tbody>
      </table>

    </div>
  </div>
</template>



<style>
#ssafy_logo{
	width: 150px;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
