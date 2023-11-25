<template>
  <div class="list-container">
    <ul class="to-do-items">
      <li class="item" v-if="itemId != item.itemId">{{ item.item }}</li>
      <li class="edit-bar" v-if="itemId == item.itemId">
        <input type="text" v-model="$store.state.updatedItem.item"/>
      </li>

      <button class="edit-btn" v-on:click="itemId=item.itemId, $store.state.updatedItem.item=item.item, $store.state.updatedItem.itemId=item.itemId" 
      v-if="itemId != item.itemId">Edit</button>
      <button class="cancel-btn" v-on:click="itemId = null" v-if="itemId == item.itemId">Cancel</button>
      <button class="dlt-btn" v-on:click="deleteItem(item.itemId)" v-if="itemId != item.itemId && $store.state.checkedItemIds.length == 0">Remove</button>
      <button class="update-btn" v-on:click="update()" v-if="itemId == item.itemId">Update</button>

      <input type="checkbox" id="dlt-box" v-bind:value="item.itemId" v-model="$store.state.checkedItemIds"/>

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
      editOption: false,
      itemId: null,
      updatedItem: {
        itemId: null,
        item: ""
      }
    }
  },
  methods: {
    deleteItem(id) {
      BackendService.deleteListItem(id).then((response) => {
        if(response.status == 200) {
          location.reload();
        }
      })
    },
    update() {
      BackendService.editListItem(this.$store.state.updatedItem).then((response) => {
        if(response.status == 200) {
          alert("Item has been changed");
          location.reload();
        }
      })
    }
  }
}
</script>

<style>
ul {
  list-style-position: inside;
  text-align: left;
  margin-left: 35vw;
  font-size: 2em;
}
</style>