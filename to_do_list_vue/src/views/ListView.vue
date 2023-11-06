<template>
  <div class="list-view">
    <h1 class="to-do-title">To Do List</h1>
    <div class="current-list">
        <list-contents/>
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
    }
}
</script>

<style>

</style>