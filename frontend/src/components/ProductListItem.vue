<template>
  <b-list-group-item class="d-flex justify-content-between align-items-center">
    {{ lineItem.amount }} x
    {{ lineItem.productName }}
    {{ unitPrice }} =
    {{ finalPrice }}
    <div class="d-flex justify-content-center " style="width: 80px">
      <img :src="image" :alt="lineItem.productName" class="p-2">
    </div>
  </b-list-group-item>
</template>
<script>
export default {
  name: 'ProductListItem',
  props: {
    lineItem: Object
  },
  created: function () {
    console.log("product received", this.lineItem)
  },
  computed: {
    unitPrice: function () {
      return (this.lineItem.unitPrice / 100).toFixed(2) + " zł"
    },
    finalPrice: function () {
      return (this.lineItem.finalPrice / 100).toFixed(2) + " zł"
    }
  },
  data() {
    return {
      image: require('@/assets/' + this.lineItem.productName + ".jpeg"),
    }
  }
}
</script>
<style scoped>
img {
  max-width: 80px;
  max-height: 50px;
}
</style>