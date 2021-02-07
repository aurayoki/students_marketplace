new Vue({
    el: '#app',
    template: `<div class="container-fluid">
    <div class="row justify-content-md-center">
        <div class="col-8 mt-5">
            <ul class="list-unstyled">
                <li class="media bg-light m-3 border rounded shadow-sm" v-for="goods in all_goods">
                    <div class="media col p-3">
                            <img src="..." class="align-self-center mr-3 w-25 h-25 p-2" alt="">
                            <div class="media-body">
                                <h3 class="mt-0 text-primary">{{goods.name}}</h3>
                                <h5 class="mt=0">{{goods.price}} &#8381;</h5>
                                <p>{{goods.description}}</p>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>`,
    data() {
        return {
            all_goods: []
        };
    },
    mounted() {
        axios
            .get('http://localhost:8080/api/v1/goods')
            .then(response => (this.all_goods = response.data));
    }
});