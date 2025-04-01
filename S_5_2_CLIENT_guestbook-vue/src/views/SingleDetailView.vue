<script setup>
import axios from '@/util/http-common';
import { onMounted, ref } from 'vue';
import { useRoute } from 'vue-router';
import moment from 'moment';

const user = ref({})
const route = useRoute();

onMounted(() => {
  axios
    .get('/admin/user/'+route.params.userid)
    .then(({ data }) => {
      user.value = data
    })
    .catch(() => {
      alert('에러가 발생했습니다.');
    })
});

</script>

<template>
  <div>
    <table class='table table-bordered'>
      <tbody>
        <tr>
          <th> 아이디 </th>
          <td> {{user.userid}} </td>
          <th> 회원명 </th>
          <td> {{user.username}} </td>
        </tr>
        <tr>
          <th> 이메일 </th>
          <td> {{user.email}} </td>
          <th> 가입일 </th>
          <td> {{moment(new Date(user.joindate)).format('YYYY.MM.DD')}} </td>
        </tr>
        <tr>
          <th> 주소 </th>
          <td colspan="3"> {{user.address}} </td>
        </tr>
      </tbody>
    </table>
    <div align="right">
      <RouterLink :to="{name:'list'}"><button class="btn btn-outline-success">목록</button></RouterLink>
    </div>
  </div>
</template>

