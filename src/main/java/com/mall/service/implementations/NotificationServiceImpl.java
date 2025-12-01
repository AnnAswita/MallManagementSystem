/*
 * package com.mall.service.implementations;
 * 
 * import com.mall.model.Notification; import
 * com.mall.repository.NotificationFileRepository; import
 * com.mall.service.interfaces.INotificationService; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service; import java.util.List;
 * 
 * @Service public class NotificationServiceImpl implements
 * INotificationService{
 * 
 * @Autowired private NotificationFileRepository repo;
 * 
 * @Override public void sendNotification(String message, int staffId) {
 * List<Notification> list = repo.load();
 * 
 * Notification n = new Notification(); n.setMessage(message);
 * n.setReceiverStaffId(staffId);
 * 
 * list.add(n); repo.save(list); }
 * 
 * }
 */