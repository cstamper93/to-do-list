<template>
  <div class="list-view">
    <h1 class="to-do-title">To Do List</h1>
    <div class="current-list">
        <list-contents v-for="item in listItems" v-bind:key="item.id" 
        v-bind:item="item" />
    </div>
    <div class="user-input">
        <form>
            <input type="text" v-model="$store.state.newItem"/>
            <!-- add button here to call method -->
            <button class="btn" v-on:click="addToList()">Add</button>
        </form>
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
            newItem: ""
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
        }
    }
}
</script>

<style>

</style>