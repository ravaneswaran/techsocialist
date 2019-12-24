package com.techsocialist.utilities.mail.impl;

import com.techsocialist.utilities.mail.api.IMailClient;
import com.techsocialist.utilities.temp.Temporary;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Ignore;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;

@Ignore
public class TestMailClient extends TestCase {

	private IMailClient mailClient;

	private String[] getTempFiles() throws IOException {
		File tempFile = Temporary.createTempFile();
		String[] fileNames = {tempFile.getAbsolutePath()};
		return fileNames;
	}

	@Override
	protected void setUp() throws Exception {
		String host = "mail.techsocialist.com";
		String port = "25";
		String userName = "testuser1@mail.techsocialist.com";
		String password = "testuser1";
		this.mailClient = MailClient.getInstance();
		this.mailClient.connect(host, port, userName, password);
	}

	public void testInitiliaze() {
		Assert.assertNotNull(this.mailClient);
	}

	public void testSendMail() throws MessagingException {
		String from = "testuser1@mail.techsocialist.com";
		String to = "testuser1@mail.techsocialist.com";
		String subject = "test subject";
		String message = "test message";
		this.mailClient.sendMail(from, to, subject, message);
	}

	public void testSendMailWithCC() throws MessagingException {
		String from = "testuser1@mail.techsocialist.com";
		String to = "testuser1@mail.techsocialist.com";
		String[] ccs = {"testuser2@mail.techsocialist.com", "testuser3@mail.techsocialist.com"};
		String subject = "test subject";
		String message = "test message";
		this.mailClient.sendMail(from, to, ccs, subject, message);
	}

	public void testSendMailWithCCAndBcc() throws MessagingException {
		String from = "testuser1@mail.techsocialist.com";
		String to = "testuser1@mail.techsocialist.com";
		String[] ccs = {"testuser2@mail.techsocialist.com", "testuser3@mail.techsocialist.com"};
		String[] bccs = {"testuser5@mail.techsocialist.com", "testuser5@mail.techsocialist.com"};
		String subject = "test subject";
		String message = "test message";
		this.mailClient.sendMail(from, to, ccs, bccs, subject, message);
	}

	public void testSendMailWithCCAndBccAndAttachments()
			throws MessagingException, IOException {
		String from = "testuser1@mail.techsocialist.com";
		String to = "testuser1@mail.techsocialist.com";
		String[] ccs = {"testuser2@mail.techsocialist.com", "testuser3@mail.techsocialist.com"};
		String[] bccs = {"testuser5@mail.techsocialist.com", "testuser5@mail.techsocialist.com"};
		String[] attachments = this.getTempFiles();
		String subject = "test subject";
		String message = "test message";
		this.mailClient
				.sendMail(from, to, ccs, bccs, attachments, subject, message);
	}

	public void testSendMailWithTosAndCCAndBccAndAttachments()
			throws MessagingException, IOException {
		String from = "testuser1@mail.techsocialist.com";
		String[] tos = {"testuser1@mail.techsocialist.com"};
		String[] ccs = {"testuser2@mail.techsocialist.com", "testuser3@mail.techsocialist.com"};
		String[] bccs = {"testuser4@mail.techsocialist.com", "testuser5@mail.techsocialist.com"};
		String[] attachments = this.getTempFiles();
		String subject = "test subject";
		String message = "test message";
		this.mailClient.sendMail(from, tos, ccs, bccs, attachments, subject,
				message);
	}

	/*@Ignore
	public void testCheckFolder_INBOX_Using_IMAP() throws MessagingException {
		String host = "mail.techsocialist.com";
		String port = "25";
		String userName = "testuser1@mail.techsocialist.com";
		String password = "testuser1";
		this.mailClient = techsocialistMailClient.getInstance();
		this.mailClient.connect(host, port, userName, password);

		Message[] messages = this.mailClient.checkFolder("INBOX", "imaps");

		Assert.assertNotNull(messages);
		Assert.assertTrue(messages.length > 0);
	}

	@Ignore
	public void testCheckFolder_INBOX_Using_POP3() throws MessagingException {
		String host = "smtp.gmail.com";
		String port = "25";
		String userName = "testuser1@mail.techsocialist.com";
		String password = "testuser1";
		this.mailClient = techsocialistMailClient.getInstance();
		this.mailClient.connect(host, port, userName, password);

		Message[] messages = this.mailClient.checkFolder("INBOX", "pop3s");

		Assert.assertNotNull(messages);
		Assert.assertTrue(messages.length > 0);
	}

	@Ignore
	public void testGetUnReadMessages_INBOX_Using_IMAP_with_Encryption() throws MessagingException {
		String host = "smtp.gmail.com";
		String port = "25";
		String userName = "testuser1@mail.techsocialist.com";
		String password = "testuser1";
		this.mailClient = techsocialistMailClient.getInstance();
		this.mailClient.connect(host, port, userName, password);

		Message[] messages = this.mailClient.getUnReadMessages("INBOX", "imaps", true);

		Assert.assertNotNull(messages);
		Assert.assertTrue(messages.length > 0);
	}

	@Ignore
	public void testGetUnReadMessages_INBOX_Using_POP3_with_Encryption() throws MessagingException {
		String host = "smtp.gmail.com";
		String port = "25";
		String userName = "testuser1@mail.techsocialist.com";
		String password = "testuser1";
		this.mailClient = techsocialistMailClient.getInstance();
		this.mailClient.connect(host, port, userName, password);

		Message[] messages = this.mailClient.getUnReadMessages("INBOX", "pop3s", true);

		Assert.assertNotNull(messages);
		Assert.assertTrue(messages.length > 0);
	}

	@Ignore
	public void testGetSentMessages_INBOX_Using_IMAP() throws MessagingException {
		String host = "smtp.gmail.com";
		String port = "25";
		String userName = "testuser1@mail.techsocialist.com";
		String password = "testuser1";
		this.mailClient = techsocialistMailClient.getInstance();
		this.mailClient.connect(host, port, userName, password);

		Message[] messages = this.mailClient.getSentMessages("INBOX", "imaps", true);

		Assert.assertNotNull(messages);
		Assert.assertTrue(messages.length >= 0);
	}

	@Ignore
	public void testGetDraftMessages_INBOX_Using_IMAP() throws MessagingException {
		String host = "smtp.gmail.com";
		String port = "25";
		String userName = "testuser1@mail.techsocialist.com";
		String password = "testuser1";
		this.mailClient = techsocialistMailClient.getInstance();
		this.mailClient.connect(host, port, userName, password);

		Message[] messages = this.mailClient.getDrafts("INBOX", "imaps", true);

		Assert.assertNotNull(messages);
		Assert.assertTrue(messages.length >= 0);
	}*/
}
