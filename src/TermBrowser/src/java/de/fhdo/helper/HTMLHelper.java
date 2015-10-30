/* 
 * CTS2 based Terminology Server and Terminology Browser
 * Copyright (C) 2014 FH Dortmund: Peter Haas, Robert Muetzner
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
package de.fhdo.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Robert Mützner
 */
public class HTMLHelper
{

  private static final Pattern REMOVE_TAGS = Pattern.compile("<.+?>");

  public static String removeTags(String string)
  {
    if (string == null || string.length() == 0)
    {
      return string;
    }
    Matcher m = REMOVE_TAGS.matcher(string);
    return m.replaceAll("");
  }
}