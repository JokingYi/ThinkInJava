package com.lzh.enums;

/**
 * ������RainClass���жԱ�
 * --enum�п��Զ���abstract������
 * --ÿ��enumʵ����Ӧ��ͬ����Ϊ
 * --�������غ���		
 * @author ASUS
 *
 */
public enum ConstantSpecificMethod
{
	FAT{
		@Override
		void getInfo()
		{
			System.out.println("�Ŀ�����");
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
