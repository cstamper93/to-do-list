<template>
  <div class="list-container">
    <ul class="to-do-items">
      <li class="item">{{ item.item }}</li>
      <button class="edit-btn" v-on:click="editItem()">Edit</button>
      <button class="dlt-btn" v-on:click="deleteItem(item.itemId)">Remove</button>
    </ul>
    
  </div>
</template>

<script>
import BackendService from '@/services/BackendService';

export default {
  name: 'list-contents',
  props: {
    item: Object
  },
  data() {
    return {
      
    }
  },
  methods: {
    deleteItem(id) {
      BackendService.deleteListItem(id).then((response) => {
        if(response.status == 200) {
          location.reload();
        }
      })
    }
  }
}
</script>

<style>

</style>