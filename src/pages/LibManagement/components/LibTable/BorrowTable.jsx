import React, { useState, useEffect } from 'react';
import CustomTable from './CustomTable';
import TableFilter from './TableFilter';
import styles from './index.module.scss';

// MOCK 数据，实际业务按需进行替换
const getData = () => {
  return Array.from({ length: 20 }).map((item, index) => {
    return {
      number: `${index}`,
      isbn: `1000${index}`,
      cate: '计算机',
      bookName: '软件工程导论',
      idCard: `12345${index}`,
      authorName: '淘小宝',
      borrowDate: '2018-10-01',
      returnDate: '2019-10-01',
    };
  });
};

export default function BorrowTable() {
  const [isLoading, setIsloading] = useState(false);
  const [dataSource, setDataSource] = useState([]);

  useEffect(() => {
    fetchData();
  }, []);


  const mockApi = () => {    
    return new Promise((resolve) => {
     //  setTimeout(() => {
       fetch("/api/borrow")
       .then( res => res.json() ).then(res => resolve(res))

     // resolve(getData());
     //  }, 600);
    });
 };
 const getFilterDataSource = (filter_data, data) => {
  for (let [property, value] of Object.entries(filter_data)) {
    data = data.filter((item) => 

      String(item[property]).includes(String(value))
    );
  }
  return data;
}
  const fetchData = async (filter_data) => {
    await setIsloading(true);
    mockApi().then((data) => {
        if (filter_data) {
          setDataSource(getFilterDataSource(filter_data, data));
        } else {
          setDataSource(data);
        }
        setIsloading(false);
    });
  };

  const handlePaginationChange = (current) => {
    fetchData(current);
  };

  const handleFilter = (filter_data) => {
    fetchData(filter_data);
  };

  const renderOper = () => {
    return <a className={`${styles.button} ${styles.detailButton}`}>查看</a>;
  };

  const config = [
    {
      label: '用户ID',
      component: 'Input',
      componnetProps: {
        placeholder: '请输入',
      },
      formBinderProps: {
        name: 'user_id', 
        triggerType: 'onBlur',
      },
    },
    // {
    //   label: 'ISBN 号',
    //   component: 'Input',
    //   componnetProps: {
    //     placeholder: '请输入',
    //   },
    //   formBinderProps: {
    //     name: 'isbn',
    //     triggerType: 'onBlur',
    //   },
    // },
    // {
    //   label: '出版社',
    //   component: 'Input',
    //   componnetProps: {
    //     placeholder: '请输入',
    //   },
    //   formBinderProps: {
    //     name: 'publisher',
    //     triggerType: 'onBlur',
    //   },
    // },
  ];
  const columns = [
    {
      title: '借阅编号',
      dataIndex: 'id',
    },
    {
      title: '图书 ISBN 号',
      dataIndex: 'book.isbn',
    },
    {
      title: '图书名称',
      dataIndex: 'book.name',
    },
    // {
    //   title: '图书类型',
    //   dataIndex: 'book_id',
    // },
    {
      title: '读者证件号',
      dataIndex: 'user_id',
    },
    // {
    //   title: '读者名称',
    //   dataIndex: 'user_id',
    // },
    {
      title: '借阅日期',
      dataIndex: 'borrow_date',
    },
    {
      title: '归还日期',
      dataIndex: 'due_date',
    },
    // {
    //   title: '操作',
    //   dataIndex: 'oper',
    //   cell: renderOper,
    // },
  ];
  console.log(this);
  return (
    <div>
      <TableFilter config={config} onChange={handleFilter} />
      <CustomTable
        isLoading={isLoading}
        dataSource={dataSource}
        columns={columns}
        paginationChange={handlePaginationChange}
      />
    </div>
  );
}
