import React, { useState, useEffect } from 'react';
import IceContainer from '@icedesign/container';
import {
  Input,
  Button,
  Select,
  DatePicker,
  Radio,
  Message,
} from '@alifd/next';
import {
  FormBinderWrapper as IceFormBinderWrapper,
  FormBinder as IceFormBinder,
} from '@icedesign/form-binder';
import styles from './index.module.scss';

const { Option } = Select;
const { Group: RadioGroup } = Radio;

export default function RecommendForm() {
  const [value, setValue] = useState({
    // status: 'borrow',
  });
  const [dataSource, setDataSource] = useState([]);

  useEffect(() => {
    fetchData();
  }, []);

  const mockApi = () => {    
     return new Promise((resolve) => {
      //  setTimeout(() => {
        fetch("/api/booklist")
        .then( res => res.json() ).then(res => resolve(res.map(item => ({"id": item.id, "name": item.name }))))

      // resolve(getData());
      //  }, 600);
     });
  };

  const fetchData = async () => {
    // await setIsloading(true);
    mockApi().then((data) => {
      setDataSource(data);
      // setIsloading(false);
    });
  };

  const formChange = newValue => setValue(newValue);

  let formRef;
  const validateAllFormField = () => {
    formRef.validateAll((errors, values) => {
      if (errors) {
        console.log({ errors });
      }
      console.log({ values });
      fetch("/api/addborrow", {
        "method": "POST",
        "headers": {
          "content-type": "application/json",
        },
        "body": JSON.stringify({ book_id: value.book_id, borrow_date: value.borrow_date.valueOf(), "user_id": window.localStorage.getItem("userid")}),
      }).then(res => res.json()).then(res => {
        if (res.code === 0) {
          Message.success('成功~');
          // window.localStorage.setItem("userid", values.username);
        }
      })
      Message.success('提交成功');
    });
  };
  
  return (
    <IceContainer>
      <div className={styles.title}>图书借阅</div>
      <IceFormBinderWrapper
        value={value}
        onChange={formChange}
        ref={form => formRef = form}
      >
        <div className={styles.formContent}>
          <div className={styles.formItem}>
            <div className={styles.formLabel}>图书名称</div>
            <IceFormBinder name="book_id">
              <Select
                placeholder="请选择"
                // mode="multiple"
                className={styles.selectWidth}
              >
              {
                dataSource.map(item => 
                  <Option value={item.id}>{item.name}</Option>

              )
            }
                {/* <Option value="book2">大数据供应链</Option>
                <Option value="book3">深度学习</Option>
                <Option value="book4">裂变</Option>
                <Option value="book5">归属感</Option>
                <Option value="book6">沉默的大多数</Option> */}
              </Select>
            </IceFormBinder>
          </div>
          {/* <div className={styles.formItem}>
            <div className={styles.formLabel}>借阅/归还</div>
            <IceFormBinder name="status">
              <RadioGroup
      
                dataSource={[
                  {
                    value: 'borrow',
                    label: '借阅',
                  },
                  {
                    value: 'return',
                    label: '归还',
                  },
                ]}
              />
            </IceFormBinder>
          </div> */}
          {/* <div className={styles.formItem}>
            <div className={styles.formLabel}>借阅证</div>
            <IceFormBinder name="idNumber">
              <Input
                placeholder="请输入借阅证号码"
                className={styles.selectWidth}
              />
            </IceFormBinder>
          </div> */}
          <div className={styles.formItem}>
            <div className={styles.formLabel}>借阅时间</div>
            <IceFormBinder name="borrow_date">
              <DatePicker
                className={styles.selectWidth}
              />
            </IceFormBinder>
          </div>
          <Button
            type="primary"
            className={styles.submitButton}
            onClick={validateAllFormField}
          >
            提 交
          </Button>
        </div>
      </IceFormBinderWrapper>
    </IceContainer>
  );
}
