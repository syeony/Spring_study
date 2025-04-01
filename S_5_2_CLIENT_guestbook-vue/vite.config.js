import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    },
  },
  build: { //html, css, js를 위치시킬 경로. -> spring의 static 폴더에 위치. 백슬래시는 정슬래시로 변경. 
    outDir: 'C:/SSAFY/worksapce_spring/S_5_2_guestbook_rest_api_starter/src/main/resources/static'
  }
})
