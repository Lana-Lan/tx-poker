<template>
  <div>
    <Card>
      <Row>
        <h3>{{ title }}</h3>
      </Row>
      <Row v-for="(msg, index) in messages" :key="'-'+index">
        <tag>{{ msg }}</tag>
      </Row>
    </Card>
  </div>
</template>

<script>
export default {
  name: "MessageCard",
  props: {
    title: '',
    messages: []
  },
  data() {
    return {
      arr:
      [
        {'key':123,'v':456},
        {'key':789,'v':101112},
      ]
    };
  },
}
</script>

<style scoped>

</style>
