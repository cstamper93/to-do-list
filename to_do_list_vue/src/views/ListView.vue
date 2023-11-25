<template>
  <div class="list-view">

    <h1 class="to-do-title">To Do List</h1>

    <div class="div-bar"></div>

    <div class="current-list">
        <list-contents v-for="item in listItems" v-bind:key="item.id" 
        v-bind:item="item" />
    </div>
    <div class="user-input">
        <form>
            <input type="text" v-model="$store.state.newItem.item"/>
            <button class="add-btn" v-on:click="addToList()">Add</button>
        </form>
    </div>
    <div>
        <button class="dlt-all-btn" v-if="$store.state.checkedItemIds.length > 0" v-on:click="deleteAll">Remove All Checked</button>
    </div>
  </div>
</template>

<script>
import BackendService from '@/services/BackendService.js'
import ListContents from '@/components/ListContents.vue'

export default {
    components: { ListContents },
    name: 'list-view',
    data() {
        return {
            listItems: [],
            newItem: {}
        }
    },
    created() {
        BackendService.fetchAllListItems().then((response) => {
            this.listItems = response.data;
        })
    },
    methods: {
        addToList() {
            this.newItem = this.$store.state.newItem;
            BackendService.addListItem(this.newItem).then((response) => {
                if(response.status === 200) {
                    location.reload;
                }
            })
        },
        deleteAll() {
            for(let i=0; i<this.$store.state.checkedItemIds.length; i++) {
                BackendService.deleteListItem(this.$store.state.checkedItemIds[i]);
            }
            alert("All selected items removed");
            location.reload();
        }
    }
}
</script>

<style>
h1 {
    font-size: 2.75em; 
}

.div-bar {
    width: 100vw;
    height: 10px;
    color: black;
}
</style>