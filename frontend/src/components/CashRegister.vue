<template>
  <div class="hello container">
    <div class="row">
      <form v-on:submit.prevent="get()" class="form col-sm-2">
        <b-form-input v-model="id" placeholder="Cash Register id"></b-form-input>
      </form>
      <form v-on:submit.prevent="submit()" class="form col-sm-5">
        <b-form-input v-model="input" placeholder="Scan item"></b-form-input>
        <b-button v-if="lineItems.length > 0" v-on:click="checkout" style="margin-top: 30px">Checkout</b-button>
      </form>
      <div class="col-sm-5">
        <div style="height: 38px; font-size: 23px" class="border rounded ">
          Total: {{ formattedTotalPrice }}
        </div>
        <ItemsList :line-items="lineItems"/>
      </div>

      <b-modal id="modal-1"
               title="Checkout in progress"
               :hide-footer="true"
               :no-close-on-backdrop="true"
               :no-close-on-esc="true"
               >
        <div class="d-flex justify-content-center">
          <b-spinner label="Spinning"></b-spinner>
        </div>
      </b-modal>
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
      input: "",
      lineItems: [],
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
            this.lineItems = response.data.lineItems;
            this.totalPrice = response.data.totalPrice
          });
    },
    submit() {
      let url = 'http://localhost:8080/cash-register/' + this.id + '/' + this.input;
      console.log('Getting product info ' + url)
      this.$http.put(url)
          .then(response => {
            console.log(response.data)
            this.lineItems = response.data.lineItems;
            this.totalPrice = response.data.totalPrice
          });
      this.input = ""
    },
    checkout() {
      console.log("Checkout")
      this.$bvModal.show("modal-1")
      this.$http.post("http://localhost:8080/cash-register/" + this.id)
          .then(response => {
            console.log(response.data)
            this.lineItems = []
            this.totalPrice = 0
            this.$bvModal.hide("modal-1")
          });

    }
  },
  name: 'CashRegister',
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
