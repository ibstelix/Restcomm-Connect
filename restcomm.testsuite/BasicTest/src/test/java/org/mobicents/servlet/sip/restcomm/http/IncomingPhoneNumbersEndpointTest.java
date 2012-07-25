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
package org.mobicents.servlet.sip.restcomm.http;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import org.junit.Test;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.IncomingPhoneNumberFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.IncomingPhoneNumber;

/**
 * @author quintana.thomas@gmail.com (Thomas Quintana)
 */
// @RunWith(Arquillian.class)
public class IncomingPhoneNumbersEndpointTest extends AbstractEndpointTest {
  public IncomingPhoneNumbersEndpointTest() {
    super();
  }
  
  @Test public void test() throws TwilioRestException {
    final TwilioRestClient client = new TwilioRestClient("ACae6e420f425248d6a26948c17a9e2acf",
        "77f8c12cc7b8f8423e5c38b035249166");
    final Account account = client.getAccount();
    final IncomingPhoneNumberFactory factory = account.getIncomingPhoneNumberFactory();
    final Map<String, String> parameters = new HashMap<String, String>();
    parameters.put("PhoneNumber", "+12223334444");
    final IncomingPhoneNumber incomingPhoneNumber = factory.create(parameters);
    assertTrue(incomingPhoneNumber.getAccountSid().equals("ACae6e420f425248d6a26948c17a9e2acf"));
    assertTrue(incomingPhoneNumber.getPhoneNumber().equals("+12223334444"));
  }
}
