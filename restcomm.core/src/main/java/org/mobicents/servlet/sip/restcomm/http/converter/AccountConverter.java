/*
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.mobicents.servlet.sip.restcomm.http.converter;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import org.mobicents.servlet.sip.restcomm.annotations.concurrency.ThreadSafe;
import org.mobicents.servlet.sip.restcomm.entities.Account;

/**
 * @author quintana.thomas@gmail.com (Thomas Quintana)
 */
@ThreadSafe public final class AccountConverter extends AbstractConverter implements JsonSerializer<Account> {
  private final String apiVersion;
  
  public AccountConverter(final String apiVersion) {
    super();
    this.apiVersion = apiVersion;
  }
  
  @SuppressWarnings("rawtypes")
  @Override public boolean canConvert(final Class klass) {
    return Account.class.equals(klass);
  }

  @Override public void marshal(final Object object, final HierarchicalStreamWriter writer,
      final MarshallingContext context) {
    final Account account = (Account)object;
    writer.startNode("Account");
    writeSid(account.getSid(), writer);
    writeFriendlyName(account.getFriendlyName(), writer);
    writeStatus(account.getStatus().toString(), writer);
    writeType(account.getType().toString(), writer);
    writeDateCreated(account.getDateCreated(), writer);
    writeDateUpdated(account.getDateUpdated(), writer);
    writeAuthToken(account, writer);
    writeUri(account.getUri(), writer);
    writeSubResourceUris(account, writer);
    writer.endNode();
  }
  
  @Override public JsonElement serialize(final Account account, final Type type,
      final JsonSerializationContext context) {
    final JsonObject object = new JsonObject();
    writeSid(account.getSid(), object);
    writeFriendlyName(account.getFriendlyName(), object);
    writeType(account.getType().toString(), object);
    writeStatus(account.getStatus().toString(), object);
    writeDateCreated(account.getDateCreated(), object);
    writeDateUpdated(account.getDateUpdated(), object);
    writeAuthToken(account, object);
    writeUri(account.getUri(), object);
    writeSubResourceUris(account, object);
    return object;
  }
  
  private String toPrefix(final Account account) {
    final StringBuilder buffer = new StringBuilder();
    buffer.append("/").append(apiVersion).append("/Accounts/").append(account.getSid().toString());
    return buffer.toString();
  }
  
  private void writeAuthToken(final Account account, final HierarchicalStreamWriter writer) {
    writer.startNode("AuthToken");
    writer.setValue(account.getAuthToken());
    writer.endNode();
  }
  
  private void writeAuthToken(final Account account, final JsonObject object) {
    object.addProperty("auth_token", account.getAuthToken());
  }
  
  private void writeAvailablePhoneNumbers(final Account account, final HierarchicalStreamWriter writer) {
    writer.startNode("AvailablePhoneNumbers");
    writer.setValue(toPrefix(account) + "/AvailablePhoneNumbers");
    writer.endNode();
  }
  
  private void writeAvailablePhoneNumbers(final Account account, final JsonObject object) {
    object.addProperty("available_phone_numbers", toPrefix(account) + "/AvailablePhoneNumbers.json");
  }
  
  private void writeCalls(final Account account, final HierarchicalStreamWriter writer) {
    writer.startNode("Calls");
    writer.setValue(toPrefix(account) + "/Calls");
    writer.endNode();
  }
  
  private void writeCalls(final Account account, final JsonObject object) {
    object.addProperty("calls", toPrefix(account) + "/Calls.json");
  }
  
  private void writeConferences(final Account account, final HierarchicalStreamWriter writer) {
    writer.startNode("Conferences");
    writer.setValue(toPrefix(account) + "/Conferences");
    writer.endNode();
  }
  
  private void writeConferences(final Account account, final JsonObject object) {
    object.addProperty("conferences", toPrefix(account) + "/Conferences.json");
  }
  
  private void writeIncomingPhoneNumbers(final Account account, final HierarchicalStreamWriter writer) {
    writer.startNode("IncomingPhoneNumbers");
    writer.setValue(toPrefix(account) + "/IncomingPhoneNumbers");
    writer.endNode();
  }
  
  private void writeIncomingPhoneNumbers(final Account account, final JsonObject object) {
    object.addProperty("incoming_phone_numbers", toPrefix(account) + "/IncomingPhoneNumbers.json");
  }
  
  private void writeNotifications(final Account account, final HierarchicalStreamWriter writer) {
    writer.startNode("Notifications");
    writer.setValue(toPrefix(account) + "/Notifications");
    writer.endNode();
  }
  
  private void writeNotifications(final Account account, final JsonObject object) {
    object.addProperty("notifications", toPrefix(account) + "/Notifications.json");
  }
  
  private void writeOutgoingCallerIds(final Account account, final HierarchicalStreamWriter writer) {
    writer.startNode("OutgoingCallerIds");
    writer.setValue(toPrefix(account) + "/OutgoingCallerIds");
    writer.endNode();
  }
  
  private void writeOutgoingCallerIds(final Account account, final JsonObject object) {
    object.addProperty("outgoing_caller_ids", toPrefix(account) + "/OutgoingCallerIds.json");
  }
  
  private void writeRecordings(final Account account, final HierarchicalStreamWriter writer) {
    writer.startNode("Recordings");
    writer.setValue(toPrefix(account) + "/Recordings");
    writer.endNode();
  }
  
  private void writeRecordings(final Account account, final JsonObject object) {
    object.addProperty("recordings", toPrefix(account) + "/Recordings.json");
  }
  
  private void writeSandBox(final Account account, final HierarchicalStreamWriter writer) {
    writer.startNode("Sandbox");
    writer.setValue(toPrefix(account) + "/Sandbox");
    writer.endNode();
  }
  
  private void writeSandBox(final Account account, final JsonObject object) {
    object.addProperty("sandbox", toPrefix(account) + "/Sandbox.json");
  }
  
  private void writeSmsMessages(final Account account, final HierarchicalStreamWriter writer) {
    writer.startNode("SMSMessages");
    writer.setValue(toPrefix(account) + "/SMSMessages");
    writer.endNode();
  }
  
  private void writeSmsMessages(final Account account, final JsonObject object) {
    object.addProperty("sms_messages", toPrefix(account) + "/SMS/Messages.json");
  }
  
  private void writeSubResourceUris(final Account account, final HierarchicalStreamWriter writer) {
    writer.startNode("SubresourceUris");
    writeAvailablePhoneNumbers(account, writer);
    writeCalls(account, writer);
    writeConferences(account, writer);
    writeIncomingPhoneNumbers(account, writer);
    writeNotifications(account, writer);
    writeOutgoingCallerIds(account, writer);
    writeRecordings(account, writer);
    writeSandBox(account, writer);
    writeSmsMessages(account, writer);
    writeTranscriptions(account, writer);
    writer.endNode();
  }
  
  private void writeSubResourceUris(final Account account, final JsonObject object) {
    final JsonObject other = new JsonObject();
    writeAvailablePhoneNumbers(account, other);
    writeCalls(account, other);
    writeConferences(account, other);
    writeIncomingPhoneNumbers(account, other);
    writeNotifications(account, other);
    writeOutgoingCallerIds(account, other);
    writeRecordings(account, other);
    writeSandBox(account, other);
    writeSmsMessages(account, other);
    writeTranscriptions(account, other);
    object.add("subresource_uris", other);
  }
  
  private void writeTranscriptions(final Account account, final HierarchicalStreamWriter writer) {
    writer.startNode("Transcriptions");
    writer.setValue(toPrefix(account) + "/Transcriptions");
    writer.endNode();
  }
  
  private void writeTranscriptions(final Account account, final JsonObject object) {
    object.addProperty("transcriptions", toPrefix(account) + "/Transcriptions.json");
  }
}
