<template>
  <div class="list-container">
    <ul class="to-do-items">
      <li class="item">{{ item.item }}</li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'list-contents',
  props: {
    item: Object
  }
}
</script>

<style>

</style>