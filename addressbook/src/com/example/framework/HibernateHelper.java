package com.example.framework;

import java.util.ArrayList;
import java.util.List;

import com.example.tests.ContactData;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class HibernateHelper extends HelperBase {

	public HibernateHelper(ApplicationManager manager) {
	  super(manager);
	}

	public List<GroupData> listGroups() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		try {
			return new SortedListOf<GroupData>(
					(List<GroupData>) session.createQuery("from GroupData").list());
		} finally {
			trans.commit();
		}
	}

	public List<String> groupNames() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		try {
			return new ArrayList<>((List<String>) session.createQuery("Select name from GroupData").list());
		} finally {
			trans.commit();
		}
	}

	public List<ContactData> listContacts() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		try {
			return new SortedListOf<ContactData>(
					(List<ContactData>) session.createQuery("from ContactData").list());
		} finally {
			trans.commit();
		}
	}
}
