<template>
  <b-list-group-item class="d-flex justify-content-between align-items-center">
    {{ product.amount }} x
    {{ product.productName }}
    {{ unitPrice }} =
    {{ finalPrice }}
    <div class="d-flex justify-content-center " style="width: 80px">
      <img :src="image" :alt="product.productName" class="p-2">
    </div>
  </b-list-group-item>
</template>
<script>
export default {
  name: 'ProductListItem',
  props: {
    product: Object
  },
  created: function () {
    console.log("product received", this.product)
  },
  computed: {
    unitPrice: function () {
      return (this.product.unitPrice / 100).toFixed(2) + " zł"
    },
    finalPrice: function () {
      return (this.product.finalPrice / 100).toFixed(2) + " zł"
    }
  },
  data() {
    return {
      image: require('@/assets/' + this.product.imagePath),
    }
  }
}
</script>
<style scoped>
img {
  max-width: 80px;
  max-height: 50px;
}

.item {
  display: block;
  /*margin: 15px 0;*/
  padding-bottom: 10px;
  border-bottom: 1px solid grey;
}
</style>