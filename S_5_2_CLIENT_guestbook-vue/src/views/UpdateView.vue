<script setup>
import axios from '@/util/http-common';
import { ref, onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';

defineProps({
  modifyUserId: String,
})

const route = useRoute();
const router = useRouter();

const form = ref(null) // form validation check

const username = ref('')
const userid = ref('')
const userpwd = ref('')
const email = ref('')
const address = ref('')

const usernameRef = ref('')
const useridRef = ref('')
const userpwdRef = ref('')
const emailRef = ref('')
const addressRef = ref('')


function checkHandler(event) {
  event.preventDefault()

  let err = true;
  let msg = '';

  !username.value &&
    ((msg = '이름을 입력해주세요'),
    (err = false),
    usernameRef.value.focus());
    console.log(err)
  err &&
    !userid.value &&
    ((msg = '아이디를 입력해주세요'), 
    (err = false), 
    useridRef.value.focus());
  err &&
    !userpwd.value &&
    ((msg = '비밀번호 입력해주세요'),
    (err = false),
    userpwdRef.value.focus());
  err &&
    !email.value &&
    ((msg = '이메일을 입력해주세요'),
    (err = false),
    emailRef.value.focus());
    err &&
    !address.value &&
    ((msg = '주소를 입력해주세요'),
    (err = false),
    addressRef.value.focus());  

  if (!err) alert(msg);
  else updateHandler()

}

function updateHandler() {
  //수정  
  axios
  .put(`/admin/user/${userid.value}`, {
    userid : userid.value,
    username : username.value,
    userpwd : userpwd.value,
    email : email.value,
    address : address.value
  })
  .then(() => {
    alert('저장 성공')
    router.push("/");
  })
  .catch(() => {
    alert('에러가 발생했습니다.')
  });
}

onMounted(() => {
  axios
    .get(`/admin/user/${route.params.userid}`)
    .then(({ data }) => {
      username.value = data.username
      userid.value = data.userid
      userpwd.value = data.userpwd
      email.value = data.email
      address.value = data.address
    })
    .catch(() => {
      alert('에러가 발생했습니다.');
    });
  },
)

</script>

<template>
  <div class="mt-2" align="left">
    <h3>회원 수정</h3>

      <form ref="form">
        <div>
          <label for="username" class="form-label">이름</label>
          <input type="text" class="form-control" id="username" ref='usernameRef' v-model="username"  required disabled>
        </div>
        <div>
          <label for="userid" class="form-label">아이디</label>
          <input type="text" class="form-control" id="userid" ref='useridRef' v-model="userid" required disabled>
        </div>
        <div>
          <label for="userpwd" class="form-label">비밀번호</label>
          <input type="text" class="form-control" id="userpwd" ref='userpwdRef' v-model="userpwd" required>
        </div>
        <div>
          <label for="email" class="form-label">이메일</label>
          <input type="text" class="form-control" id="email" ref='emailRef' v-model="email" required>
        </div>
        <div>
          <label for="address" class="form-label">주소</label>
          <input type="text" class="form-control" id="address" ref='addressRef' v-model="address" required>
        </div>
        <br>
        <div align="right">
          <button class="btn btn-outline-primary me-1" @click="checkHandler">저장</button>
          <RouterLink :to="{name:'list'}"><button class="btn btn-outline-success">목록</button></RouterLink>
        </div>
      </form>
  </div>
</template>
