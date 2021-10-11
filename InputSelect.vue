<style lang="less">
	.SI{
		display: flex;
		justify-content: space-between;
		height: 60upx;	
		.right{
			flex:1;	
			display: flex;	
			margin-right: 20upx;
			border-radius: 15upx;
			border: 2upx solid #1bbddd;
			box-sizing: border-box;
			overflow: hidden;	
			transition: flex .5s ease ,opacity .5s;
			min-width: 0;
			.rightItem{
				flex: 1;
				font-size: 28upx;
				line-height: 200%;
				text-align: center;
				color: #1bbddd;
				border-right: 1upx solid  #1bbddd;
				overflow: hidden;
				text-overflow: ellipsis;
				white-space: nowrap;
			}
			.DataIndex{
				background-color: #1bbddd;
				color: #ffffff;
			}
			.rightItem:last-child{
				border-right: 0px;
			}
		}
		.left{
			flex: 0 0 140upx;
			display: flex;						
			transition: flex .5s ease;
			.leftInput{
				flex: 1;
				color: #ffffff;
				background-color: #1bbddd;
				border-top-left-radius:15upx;
				border-bottom-left-radius: 15upx;
				.NoInput{
					text-align: center;
					line-height: 200%;		
				}
				.InputShow{
					padding: 0 20upx;
					flex: 1;				
					display: flex;
					height: 100%;	
					input{
						flex: 1;
						display: block;
						color: #ffffff !important;						
						font-size: 26upx;	
						align-self: center;
					}
					.close{
						height: 100%;
						line-height: 200%;
						transform: rotate(45deg);
					}
				}
			}
			.leftSelect{
				text-align: center;
				width: 70upx;
				color: #ffffff;	
				transition: border-radius 1s ease;
				line-height: 200%;
				border-left: 1px solid #ffffff;
				background-color: #1bbddd;
				border-top-right-radius:15upx;
				border-bottom-right-radius: 15upx;
				border-top-left-radius:0upx;
				border-bottom-left-radius: 0upx;			
			}
			.leftSelectRadius{
				border-top-left-radius:15upx !important;
				border-bottom-left-radius: 15upx !important;
			}
			view{
				font-size: 30upx;
			}
		}
		.noright{
			flex: 0 !important;
			opacity: 0;
			border:0px !important;
		}
		.inleft{
			flex: 1 !important;
		}
		.inleft140{
			flex: 0 0 140upx!important;
		}
		.inleft70{
			flex: 0 0 70upx!important;
		}
	}
</style>
<template>
	<view class="SI">
		<view :class="{'right':true,'noright':SelctFlag}" >
			 <view v-for="(item,index) in InputSelectList" :key="index" 
			 :class="{'rightItem':true,'DataIndex':DataIndex==index}"
			 :data-index="item.index"
			 @tap="DataIndexFun">
				{{item.name}}
			</view> 
		</view>
		<view :class="{'left':true,'inleft':SelctFlag==true,'inleft140':SelctFlag==false&&StyleType==0,'inleft70':SelctFlag==false&&StyleType!=0}"  >
			<view class="leftInput" >
				<navigator v-if="!SelctFlag&&StyleType==0&&navitype==0" class="NoInput  icon--03" url="../AddHouse/AddHouse" ></navigator>
				<navigator v-if="!SelctFlag&&StyleType==0&&navitype==1" class="NoInput  icon--03" url="../AddCustomer/AddCustomer"></navigator>
				<view class="InputShow" v-if="SelctFlag">
					<input placeholder="请输入小区,商圈等关键字搜索" v-model="InputVal" placeholder-style="color: #ffffff;"/> 
					<view @tap="CloseInput" class="close icon--14"></view>
				</view>
			</view>
			<view :class="{'icon--05':true, 'leftSelect':true,'leftSelectRadius':SelctFlag==false && StyleType!=0}"   @tap="DateInputChange"></view>
		</view>

	</view>
</template>

<script>
	export default {
		props:{
			InputSelectList:{
				type:Array,
				default:[],
			},
			StyleType:{
				type:Number,
				default:0
			},
			SetDataIndex:{
				type:Object,
				default:()=>{}
			},
			navitype:0,
		},
		watch: {
			 SetDataIndex:{
			   //immediate: true, 
				deep:true,
				handler(newval) {
				  this.DataIndex = newval.index;
				}
			}
		},
		data() {
			return {
				SelctFlag:false,
				DataIndex:0,
				InputVal:'',
				upx70:0,
				unx140:0
			};
		},
		methods:{
			CloseInput(){
				this.SelctFlag = false;
				this.InputVal = '';
			},
			DateInputChange(){
				if(this.InputVal==''){
					this.SelctFlag = !this.SelctFlag;	
				}else{
					this.$emit('GetInputVal',this.InputVal);
				}				
			},
			DataIndexFun(e){
				this.DataIndex =  e.currentTarget.dataset.index;
				this.$emit('GetDataIndex',this.DataIndex);
			}			
		}
	}
</script>

