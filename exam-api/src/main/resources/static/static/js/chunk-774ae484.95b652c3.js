(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-774ae484"],{"2cbf":function(t,e,n){"use strict";n("73e0")},3064:function(t,e,n){"use strict";n.d(e,"b",(function(){return i})),n.d(e,"a",(function(){return r})),n.d(e,"c",(function(){return o}));var a=n("b775");function i(t){return Object(a["b"])("/exam/api/userPost/paging",t)}function r(t){return Object(a["b"])("/exam/api/userPost/detail",t)}function o(t){return Object(a["b"])("/exam/api/userPost/save",t)}},"333d":function(t,e,n){"use strict";var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"pagination-container",class:{hidden:t.hidden}},[n("el-pagination",t._b({attrs:{background:t.background,"current-page":t.currentPage,"page-size":t.pageSize,layout:t.layout,"page-sizes":t.pageSizes,total:t.total},on:{"update:currentPage":function(e){t.currentPage=e},"update:current-page":function(e){t.currentPage=e},"update:pageSize":function(e){t.pageSize=e},"update:page-size":function(e){t.pageSize=e},"size-change":t.handleSizeChange,"current-change":t.handleCurrentChange}},"el-pagination",t.$attrs,!1))],1)},i=[];n("c5f6");Math.easeInOutQuad=function(t,e,n,a){return t/=a/2,t<1?n/2*t*t+e:(t--,-n/2*(t*(t-2)-1)+e)};var r=function(){return window.requestAnimationFrame||window.webkitRequestAnimationFrame||window.mozRequestAnimationFrame||function(t){window.setTimeout(t,1e3/60)}}();function o(t){document.documentElement.scrollTop=t,document.body.parentNode.scrollTop=t,document.body.scrollTop=t}function c(){return document.documentElement.scrollTop||document.body.parentNode.scrollTop||document.body.scrollTop}function s(t,e,n){var a=c(),i=t-a,s=20,u=0;e="undefined"===typeof e?500:e;var l=function t(){u+=s;var c=Math.easeInOutQuad(u,a,i,e);o(c),u<e?r(t):n&&"function"===typeof n&&n()};l()}var u={name:"Pagination",props:{total:{required:!0,type:Number},page:{type:Number,default:1},limit:{type:Number,default:20},pageSizes:{type:Array,default:function(){return[10,20,30,50]}},layout:{type:String,default:"total, sizes, prev, pager, next, jumper"},background:{type:Boolean,default:!0},autoScroll:{type:Boolean,default:!0},hidden:{type:Boolean,default:!1}},computed:{currentPage:{get:function(){return this.page},set:function(t){this.$emit("update:page",t)}},pageSize:{get:function(){return this.limit},set:function(t){this.$emit("update:limit",t)}}},methods:{handleSizeChange:function(t){this.$emit("pagination",{page:this.currentPage,limit:t}),this.autoScroll&&s(0,800)},handleCurrentChange:function(t){this.$emit("pagination",{page:t,limit:this.pageSize}),this.autoScroll&&s(0,800)}}},l=u,d=(n("2cbf"),n("2877")),p=Object(d["a"])(l,a,i,!1,null,"6af373ef",null);e["a"]=p.exports},3873:function(t,e,n){"use strict";n("c0ee")},"5c02":function(t,e,n){"use strict";n.r(e);var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"topic-list"},[n("div",{staticClass:"search-container"},[n("el-input",{staticClass:"search-input",attrs:{placeholder:"请输入标题"},model:{value:t.searchTitle,callback:function(e){t.searchTitle=e},expression:"searchTitle"}}),n("el-button",{attrs:{type:"primary"},on:{click:t.handleSearch}},[t._v("搜索")])],1),n("el-button",{staticClass:"publish-button",attrs:{type:"primary"},on:{click:t.handleAdd}},[t._v("发布话题")]),t._l(t.records,(function(e,a){return[n("el-descriptions",{key:e.id,class:{separator:0!==a},attrs:{size:"large",column:2},scopedSlots:t._u([{key:"title",fn:function(){return[n("div",{staticClass:"title-link",on:{click:function(n){return t.viewTopic(e)}}},[t._v(t._s(e.title))])]},proxy:!0}],null,!0)},[n("el-descriptions-item",{attrs:{label:"作者"}},[t._v(t._s(e.author?e.author.userName:"无"))]),n("el-descriptions-item",{attrs:{label:"内容"}},[n("div",{staticClass:"clamp-text"},[t._v(t._s(e.content))])]),n("el-descriptions-item",{attrs:{label:"评论"}},[n("el-badge",{attrs:{value:e.commentCount}})],1),n("el-descriptions-item",{attrs:{label:"时间"}},[t._v(t._s(t.formatDateTime(e.createTime)))])],1)]})),n("div",{staticClass:"pagination-container"},[n("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total > 0"}],attrs:{total:t.total,page:t.current,limit:t.size},on:{"update:page":function(e){t.current=e},"update:limit":function(e){t.size=e},pagination:t.fetchData}})],1)],2)},i=[],r=n("3064"),o=n("333d"),c={name:"Post",components:{Pagination:o["a"]},data:function(){return{current:1,size:10,total:0,records:[],searchTitle:"",params:{}}},mounted:function(){this.fetchData()},methods:{fetchData:function(){var t=this;Object(r["b"])({current:this.current,size:this.size,params:this.params,t:(new Date).getTime()}).then((function(e){var n=e.data,a=n.records,i=n.current,r=n.size,o=n.total;t.records=a,t.current=i,t.size=r,t.total=o})).catch((function(t){console.error("Failed to fetch data:",t)}))},handleSearch:function(){this.current=1,this.params.title=this.searchTitle,this.fetchData()},formatDateTime:function(t){return new Date(t).toLocaleString()},handleAdd:function(){this.$router.push({name:"AddPost",params:{}})},viewTopic:function(t){this.$router.push({name:"Comment",params:{id:t.id}})}}},s=c,u=(n("3873"),n("2877")),l=Object(u["a"])(s,a,i,!1,null,"1060b8d4",null);e["default"]=l.exports},"73e0":function(t,e,n){},c0ee:function(t,e,n){}}]);