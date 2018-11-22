;(function(){
    var myVue = new Vue({
        el:'.container',
        data:{
            pageInfo:{},
            ismoney:[],
            username:'',
            cardno:''
        },
        created:function(){
           dataLoad();
        },
        filters:{
            priceFilter:function(val){
                return parseInt(val)>0?"余额:"+val:"欠款:"+val;
            }
        },
        methods:{
            jump:function(page){
               dataSearch(page);

            },
            search:function(){
                dataSearch();
            }
        }
    });

    /**
     * 搜索对应的数据 并根据用户传入的页码值 组装后传入dataLoad进行页面数据修改
     * @param page 页码值
     */
    function dataSearch(page){
        page = page||1;
        var pm = {params:{}};
        if(myVue.$data.cardno.trim()!=''){
            pm.params['cardno']=myVue.$data.cardno.trim();
        }
        pm.params['username']=myVue.$data.username.trim();
        pm.params.cp=page;
        dataLoad(pm);
    }

    /**
     * 通过axios将数据传送到后端，并将返回的数据填充到vue的data数据中
     * @param pm 传入参数
     */
    function dataLoad(pm){

        pm = pm||{params:{}};
        axios.get('http://localhost:9001/search',pm).then(function(res){
            var colors =[];
            for(var u in res.data.list){
                var us = res.data.list[u];
                colors.push(parseInt(us.balance)<0?true:false);
            }
            myVue.$data.ismoney = colors;
            myVue.$data.pageInfo = res.data;
        });
    }
})();