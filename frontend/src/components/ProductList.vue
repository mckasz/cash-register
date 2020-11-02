<template>
  <div v-if="lineItems.length > 0">
    <h2 style="margin-top: 30px">Scanned items</h2>
    <b-list-group class="car-list">
      <ProductListItem v-for="lineItem in lineItems"
                       v-bind:key="lineItem.productName"
                       :line-item="lineItem"
      />
    </b-list-group>
  </div>
</template>
<script>
import ProductListItem from "@/components/ProductListItem";

export default {
  name: 'ProductList',
  components: {ProductListItem},
  props: {
    lineItems: Array
  },
  created: function () {
    console.log("Products received", this.lineItems)
  },
  updated() {
    console.log("Products received", this.lineItems)
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