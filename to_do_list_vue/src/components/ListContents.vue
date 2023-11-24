<template>
  <div class="list-container">
    <ul class="to-do-items">
      <li class="item" v-if="itemId != item.itemId">{{ item.item }}  {{ item.itemId }}</li>
      <li class="edit-bar" v-if="itemId == item.itemId">
        <input type="text" v-model="updatedItem.updatedItem"/>
      </li>

      <button class="edit-btn" v-on:click="itemId=item.itemId, updatedItem.updatedItem=item.item" v-if="itemId != item.itemId">Edit</button>
      <button class="cancel-btn" v-on:click="itemId = null" v-if="itemId == item.itemId">Cancel</button>
      <button class="dlt-btn" v-on:click="deleteItem(item.itemId)" v-if="itemId != item.itemId">Remove</button>
      <button class="done-btn" v-on:click="update(updatedItem)" v-if="itemId == item.itemId">Update</button>
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
        updatedId: null,
        updatedItem: ""
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
    update(updatedItem) {
      updatedItem = this.updatedItem;
      BackendService.editListItem(updatedItem).then((response) => {
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