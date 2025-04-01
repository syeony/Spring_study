<script setup>
import { inject } from 'vue'
import moment from 'moment';

const emitter = inject('emitter'); // Inject `emitter`

defineProps(
  {user: Object}
)

function deleteUser(userid){
  emitter.emit("deleteUser", userid)
}

</script>

<template>
  <tr>
    <td>{{ user.userid }}</td>
    <td>{{ user.userpwd }}</td>
    <td><RouterLink :to="`/detail/${user.userid}`">{{ user.username }}</RouterLink></td>
    <td>{{ user.email }}</td>
    <td>{{ user.address }}</td>
    <td v-if="user != null">{{ moment(new Date(user.joindate)).format('YYYY.MM.DD') }}</td>
    <td>
      <RouterLink :to="`/update/${user.userid}`">
        <button type="button" class="btn btn-outline-primary me-1 btn-sm">수정</button>
      </RouterLink>
      <button type="button" class="btn btn-outline-danger btn-sm" @click="deleteUser(user.userid)">삭제</button>
    </td>
  </tr>
</template>

