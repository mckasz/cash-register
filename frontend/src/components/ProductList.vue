<template>
  <div v-if="products.length > 0">
    <h2 style="margin-top: 30px">Scanned items</h2>
    <b-list-group class="car-list">
      <ProductListItem v-for="product in products"
                       v-bind:key="product.productName"
                       :product="product"
      />
    </b-list-group>
  </div>
</template>
<script>
import ProductListItem from "@/components/ProductListItem";

export default {
  name: 'ProductList',
  components: {ProductListItem},
  created: function () {
    console.log("Products received", this.products)
  },
  updated() {
    console.log("Products received", this.products)
  },
  data() {
    return {
      localProduct: {
        name: "beer",
        imagePath: "beer.jpeg",
        price: 450
      }
    }
  },
  props: {
    products: Array
  }
}
</script>
<style scoped>
h3 {
  margin: 40px 0 0;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>