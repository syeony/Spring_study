import { createRouter, createWebHistory } from 'vue-router'
import List from "../views/ListView.vue";
import SingleDetail from "../views/SingleDetailView.vue";
import Join from "../views/JoinView.vue";
import Update from "../views/UpdateView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      alias : ["/index.html"],
      name: "list",
      component: List,
    },
    {
      path: "/detail/:userid",
      name: "detail",
      component: SingleDetail,
    },
    {
      path: "/update/:userid",
      name: "update",
      component: Update,
    },
    {
      path: "/join",
      name: "join",
      component: Join,
    },
    // {
    //   path: '/about',
    //   name: 'about',
    //   // route level code-splitting
    //   // this generates a separate chunk (About.[hash].js) for this route
    //   // which is lazy-loaded when the route is visited.
    //   component: () => import('../views/AboutView.vue')
    // }
  ]
})

export default router
