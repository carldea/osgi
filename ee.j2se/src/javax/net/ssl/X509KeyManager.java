/*
 * Copyright (c) OSGi Alliance (2001, 2013). All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package javax.net.ssl;
public interface X509KeyManager extends javax.net.ssl.KeyManager {
	java.lang.String chooseClientAlias(java.lang.String[] var0, java.security.Principal[] var1, java.net.Socket var2);
	java.lang.String chooseServerAlias(java.lang.String var0, java.security.Principal[] var1, java.net.Socket var2);
	java.security.cert.X509Certificate[] getCertificateChain(java.lang.String var0);
	java.lang.String[] getClientAliases(java.lang.String var0, java.security.Principal[] var1);
	java.security.PrivateKey getPrivateKey(java.lang.String var0);
	java.lang.String[] getServerAliases(java.lang.String var0, java.security.Principal[] var1);
}
