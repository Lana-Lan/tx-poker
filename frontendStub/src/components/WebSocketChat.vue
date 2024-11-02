<template>
  <div>
    <h2>WebSocket Chat</h2>
    <Row>
      <Input  v-model="dest" placeholder="type your dest"></Input>
    </Row>
    <Row>
      <Input  v-model="message" placeholder="type your message"></Input>
    </Row>
    <Row>
      <Button  @click="sendMessage">send</Button>
    </Row>
    <Row>
      <h3>Messages:</h3>
    </Row>
    <Row v-for="(msg, index) in messages" :key="index">
      <tag>{{ msg }}</tag>
    </Row>
    <Row>
      <Col span="8">
        <message-card :title="'用户列表'" :messages="userMessages"></message-card>
      </Col>
    </Row>
  </div>
</template>

<script>
import {Client} from '@stomp/stompjs';
import SockJS from 'sockjs-client';
import MessageCard from "./MessageCard";

export default {
  data() {
    return {
      client: null,
      message: '',
      messages: [],
      userMessages:[],
      dest: '/app/login',
    };
  },
  components:{
    MessageCard
  },
  created() {
    this.connect();
  },
  methods: {
    connect() {
      this.client = new Client({
        brokerURL: 'ws://localhost:8080/websocket', // 替换为你的 WebSocket URL
        connectHeaders: {},
        debug: (str) => {
          console.log(str);
        },
        onConnect: () => {
          console.log('Connected to WebSocket');
          debugger
          this.client.subscribe('/topic/your-topic', (message) => {
            this.messages.push(message.body);
          });
          this.client.subscribe('/topic/user-list', (userMessageOri) => {
            this.userMessages=JSON.parse(userMessageOri.body);
            // console.log('user-list message',message.body);
            // console.log('user-list message json',JSON.stringify(message.body));
            // this.userMessages=JSON.stringify(message.body);
          });
        },
        onStompError: (frame) => {
          console.error('Broker error: ' + frame.headers['message']);
        },
      });

      this.client.activate();
    },
    sendMessage() {
      if (this.message) {
        this.client.publish({
          destination: this.dest, // 替换为你的消息目的地
          body: this.message,
        });
        this.message = ''; // 发送后清空输入框
      }
    },
  },
  beforeDestroy() {
    if (this.client) {
      this.client.deactivate();
    }
  },
};
</script>

<style scoped>
/* 你的样式 */
</style>
