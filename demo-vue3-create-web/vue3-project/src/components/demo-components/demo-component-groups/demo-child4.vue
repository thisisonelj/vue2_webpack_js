<template>
    <div class="vue3-card">
        <Card :style="cardStyle" @click="$attrs.onClick"></Card>
    </div>
</template>
<script setup>
import { ref, computed, watch, onMounted,defineProps,defineEmits,useAttrs  } from 'vue'
let cardStyle = ref('')
let attrsList = useAttrs()
cardStyle.value=attrsList.style
</script>
<script>
export default {
    inheritAttrs:false
}
</script>
<style scoped>
.vue3-card{
    height: 20%;
    padding: 20px;
}
</style>