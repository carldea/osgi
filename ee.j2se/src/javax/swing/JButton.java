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

package javax.swing;
public class JButton extends javax.swing.AbstractButton implements javax.accessibility.Accessible {
	protected class AccessibleJButton extends javax.swing.AbstractButton.AccessibleAbstractButton {
		protected AccessibleJButton() { } 
	}
	public JButton() { } 
	@java.beans.ConstructorProperties(value={"text"})
	public JButton(java.lang.String var0) { } 
	public JButton(java.lang.String var0, javax.swing.Icon var1) { } 
	public JButton(javax.swing.Action var0) { } 
	public JButton(javax.swing.Icon var0) { } 
	public boolean isDefaultButton() { return false; }
	public boolean isDefaultCapable() { return false; }
	public void setDefaultCapable(boolean var0) { }
}
