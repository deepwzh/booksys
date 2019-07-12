import React from 'react';
import { Link } from 'react-router-dom';
import styles from './index.module.scss';

export default function Logo(props) {
  const { style } = props;
  return (
    <Link to="/" className={styles.logoStyle} style={style}>
      图书馆管理系统
    </Link>
  );
}
