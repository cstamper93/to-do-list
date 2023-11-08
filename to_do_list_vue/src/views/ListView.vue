<template>
  <div class="list-view">
    <h1 class="to-do-title">To Do List</h1>
    <div class="current-list">
        <list-contents v-for="item in listItems" v-bind:key="item.id" 
        v-bind:item="item" />
    </div>
    <div class="user-input">
        <form>
            <input type="text" />
            <!-- add button here to call method -->
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
            listItems: []
        }
    },
    created() {
        BackendService.fetchAllListItems().then((response) => {
            this.listItems = response.data;
        })
    },
    methods: {
        addListItem(item) {
            BackendService.addToList(item).then((response) => {
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