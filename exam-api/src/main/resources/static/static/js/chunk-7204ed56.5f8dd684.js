(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-7204ed56"],{"062e":function(t,e,a){"use strict";a.d(e,"a",(function(){return n})),a.d(e,"b",(function(){return r}));var o=a("b775");function n(t){return Object(o["b"])("/exam/api/userLearningPlan/detail",t)}function r(t){return Object(o["b"])("/exam/api/userLearningPlan/save",t)}},de8d:function(t,e,a){"use strict";a.r(e);var o=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container"},[a("el-form",{ref:"postForm",attrs:{model:t.postForm,rules:t.rules,"label-position":"top","label-width":"100%"}},[a("el-card",[a("el-form-item",{attrs:{label:"规划名称",prop:"planName"}},[a("el-input",{model:{value:t.postForm.planName,callback:function(e){t.$set(t.postForm,"planName",e)},expression:"postForm.planName"}})],1),a("el-form-item",{attrs:{label:"规划描述",prop:"description"}},[a("el-input",{attrs:{type:"textarea"},model:{value:t.postForm.description,callback:function(e){t.$set(t.postForm,"description",e)},expression:"postForm.description"}})],1),a("el-form-item",{attrs:{label:"开始日期",prop:"startDate"}},[a("el-date-picker",{attrs:{type:"date",placeholder:"选择日期"},model:{value:t.postForm.startDate,callback:function(e){t.$set(t.postForm,"startDate",e)},expression:"postForm.startDate"}})],1),a("el-form-item",{attrs:{label:"结束日期",prop:"endDate"}},[a("el-date-picker",{attrs:{type:"date",placeholder:"选择日期"},model:{value:t.postForm.endDate,callback:function(e){t.$set(t.postForm,"endDate",e)},expression:"postForm.endDate"}})],1)],1),a("div",{staticStyle:{"margin-top":"20px"}},[a("el-button",{attrs:{type:"primary"},on:{click:t.submitForm}},[t._v("保存")]),a("el-button",{attrs:{type:"info"},on:{click:t.onCancel}},[t._v("返回")])],1)],1)],1)},n=[],r=a("062e"),s={name:"AddPlan",data:function(){return{postForm:{},loading:!1,rules:{planName:[{required:!0,message:"规划名称不能为空！"}],description:[{required:!0,message:"规划描述不能为空！"}],startDate:[{required:!0,message:"开始日期不能为空！"}],endDate:[{required:!0,message:"结束日期不能为空！"}]}}},created:function(){var t=this.$route.params.id;"undefined"!==typeof t&&this.fetchData(t)},methods:{handleAdd:function(){this.postForm.answerList.push({isRight:!1,content:"",analysis:""})},fetchData:function(t){var e=this,a={id:t};Object(r["a"])(a).then((function(t){e.postForm=t.data}))},submitForm:function(){var t=this;console.log(JSON.stringify(this.postForm)),this.$refs.postForm.validate((function(e){e&&Object(r["b"])(t.postForm).then((function(){t.$notify({title:"成功",message:"保存成功！",type:"success",duration:2e3}),t.$router.push({name:"Plan"})}))}))},onCancel:function(){this.$router.push({name:"Plan"})}}},i=s,l=a("2877"),p=Object(l["a"])(i,o,n,!1,null,null,null);e["default"]=p.exports}}]);