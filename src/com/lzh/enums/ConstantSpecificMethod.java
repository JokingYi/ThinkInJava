package com.lzh.enums;

/**
 * 可以与RainClass进行对比
 * --enum中可以定义abstract方法！
 * --每个enum实例对应不同的行为
 * --可以重载函数		
 * @author ASUS
 *
 */
public enum ConstantSpecificMethod
{
	FAT{
		@Override
		void getInfo()
		{
			System.out.println("心宽体胖");
		}
	},
	MEDIUM{
		@Override
		void getInfo()
		{
			System.out.println("im fine");
		}
	},
	THIN{
		@Override
		void getInfo()
		{
			System.out.println("wo yao rou");
		}
	};
	abstract void getInfo();
	
}
