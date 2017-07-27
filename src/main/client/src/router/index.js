import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import Member from '@/components/Member'
import Event from '@/components/Event'
import TeamRegist from '@/components/TeamRegist'
import MemberRegist from '@/components/MemberRegist'
import Identification from '@/components/Identification'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Hello',
      component: Hello
    },
    {
      path: '/members',
      name: 'Member',
      component: Member
    },
    {
      path: '/events',
      name: 'Event',
      component: Event
    },
    {
      path: '/team/regist',
      name: 'TeamRegist',
      component: TeamRegist
    },
    {
      path: '/member/regist',
      name: 'MemberRegist',
      component: MemberRegist
    },
    {
      path: '/identification',
      name: 'Identification',
      component: Identification
    }
  ]
})
