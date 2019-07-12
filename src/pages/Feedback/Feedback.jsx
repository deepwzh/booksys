import React, { useState, useRef } from 'react';
import { Grid, Input, Button, Message } from '@alifd/next';
import {
  FormBinderWrapper,
  FormBinder,
  FormError,
} from '@icedesign/form-binder';
import './JoinUs.scss';
import styles from './index.module.scss';

const { Row, Col } = Grid;
const telPattern = /^(1[\d]{1}[\d]{9})|(((400)-(\d{3})-(\d{4}))|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)$|^([ ]?)$/;

export default function Index() {
  const formRef = useRef(null);
  const [formValue, setFormValue] = useState({
    username: '',
    email: '',
    phone: '',
    jobtitle: '',
    content: '',
  });

  const formChange = (newValue) => {
    setFormValue(newValue);
  };

  const handleSubmit = () => {
    formRef.current.validateAll((error, value) => {
      fetch('/api/feedback', {
        method: 'POST',
        headers: {
          "content-type": "application/json",
        },
        body: JSON.stringify({
          "content": value.content,
          "user_id": window.localStorage.getItem("userid")}),
      }).then(res => res.json())
      .then(res => {
        Message.show("反馈成功")
      })
      console.log(value);
    });
  };

  return (
    <div
      className={`${styles.container} ${styles.joinUs} join-us`}
    >
      <div className={styles.content}>
        <div className={styles.head}>
          <h2 className={styles.title}>反馈</h2>
          <p className={styles.intro}>
            在这里提交有关图书管理的有关反馈
            <br />
          </p>
        </div>
        <FormBinderWrapper
          ref={formRef}
          value={formValue}
          onChange={formChange}
        >
          <div className={styles.formContent}>
            <Row
              wrap
              gutter={20}
              // className="hoz-form-item"
              className={`${styles.hozFormItem} hoz-form-item`}
            >
              <Col
                span={24}
                // className="ver-form-item"
                className={`${styles.verFormItem} ver-form-item`}
              >
                <FormBinder name="content">
                  <Input.TextArea
                    className={styles.inputWidth}
                    placeholder="反馈信息"
                  />
                </FormBinder>
              </Col>
            </Row>

            <Row>
              <Col>
                <Button
                  onClick={handleSubmit}
                  type="primary"
                  className={styles.submitBtn}
                >
                  提交
                </Button>
              </Col>
            </Row>
          </div>
        </FormBinderWrapper>
      </div>
    </div>
  );
}