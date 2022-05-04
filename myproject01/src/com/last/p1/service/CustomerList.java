package com.last.p1.service;

import com.last.p1.bean.Customer;

/**CustomerList为Customer对象的管理模块，
 * 内部用数组管理一组Customer对象，
 * 并提供相应的添加、修改、删除和遍历方法，供CustomerView调用
 *
 */
public class CustomerList {
   private Customer[] customers;//用来保存客户对象的数组
    int total = 0;//客户数量

    /**
     *用来初始化Customer数组的构造器
     * @param totalCustomer 指定数组长度
     */
    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }

    /**
     * 将指定的用户添加到数组中
     * @param customer
     * @return ture:添加成功 false：添加失败
     */
    public boolean addCustomer(Customer customer){
        if(total>=customers.length){
            return false;
        }
        customers[total++]=customer;
        return true;
    }

    /**
     * 修改指定位置的信息
     * @param index
     * @param cust
     * @return ture:修改成功 false：修改失败
     */
    public boolean replaceCustomer(int index, Customer cust){
        if(index<0||index>=total){
            return false;
        }
        customers[index]=cust;
        return true;
    }

    /**
     * 删除指定位置的信息
     * @param index
     * @return ture:删除成功 false：删除失败
     */
    public boolean deleteCustomer(int index){
        if(index<0||index>=total){
            return false;
        }
        for(int i = index;i < total -1;i--){
            customers[i] = customers[i + 1];
        }
        customers[--total]=null;
        return true;
    }

    /**
     * 获取所有客户信息
     * @return custs数组
     */
    public Customer[] getAllCustomers(){
    Customer[] custs = new Customer[total];
    for(int i = 0;i < total; i++){
        custs[i] = customers[i];
    }
        return custs;
    }

    /**
     *返回参数index指定索引位置的客户对象记录
     * @param index
     * @return 封装了客户信息的Customer对象
     */
    public Customer getCustomer(int index){
        if(index<0||index>=total){
            return null;
        }
        return customers[index];
    }

    /**
     * 返回客户数量
     * @return
     */
    public int getTotal(){
        return total;
    }

}
