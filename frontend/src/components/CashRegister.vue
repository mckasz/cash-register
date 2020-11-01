<template>
  <div class="hello container">
    <div class="row">
      <form v-on:submit.prevent="get()" class="form col-sm">
        <b-form-input v-model="id" placeholder="Cash Register id"></b-form-input>
      </form>
      <form v-on:submit.prevent="submit()" class="form col-sm">
        <b-form-input v-model="input" placeholder="Scan item"></b-form-input>
      </form>
      <div class="col-sm">
        <div style="height: 38px; font-size: 23px" class="border rounded ">
          Total: {{ formattedTotalPrice }}
        </div>
        <ItemsList :products="products" />
      </div>

    </div>
  </div>
</template>

<script>
import ItemsList from "@/components/ProductList";

export default {
  components: {ItemsList},
  computed: {
    formattedTotalPrice: function () {
      return (this.totalPrice / 100).toFixed(2) + 'zł'
    }
  },
  data() {
    return {
      id: 1,
      input: "beer",
      products: [],
      totalPrice: 0
    }
  },
  created() {
    this.get()
  },
  methods: {
    get() {
      console.log('Getting initial sate ')
      this.$http.get('http://localhost:8080/cash-register/' + this.id)
          .then(response => {
            console.log(response.data)
            this.products = response.data.lineItems;
            this.totalPrice = response.data.totalPrice
          });
    },
    submit() {
      let url = 'http://localhost:8080/cash-register/' + this.id + '/' + this.input;
      console.log('Getting product info ' + url)
      this.$http.put(url)
          .then(response => {
            console.log(response.data)
            this.products = response.data.lineItems;
            this.totalPrice = response.data.totalPrice
          });
      this.input = ""
    }
  },
  name: 'HelloWorld',
  props: {
    msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}

.form {

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
