/*
 * MinIO Java SDK for Amazon S3 Compatible Cloud Storage, (C) 2017 MinIO, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.minio.messages;

import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

/**
 * Helper class to denote common fields of CloudFunctionConfiguration, QueueConfiguration and
 * TopicConfiguration.
 */
public class NotificationCommonConfiguration {
  @Element(name = "Id")
  private String id;

  @ElementList(name = "Event", inline = true, required = false)
  private List<EventType> events;

  @Element(name = "Filter")
  private Filter filter;

  public NotificationCommonConfiguration() {}

  /** Returns id. */
  public String id() {
    return id;
  }

  /** Sets id. */
  public void setId(String id) {
    this.id = id;
  }

  /** Returns events. */
  public List<EventType> events() {
    return events;
  }

  /** Sets event. */
  public void setEvents(List<EventType> events) {
    this.events = events;
  }

  /** sets filter prefix rule. */
  public void setPrefixRule(String value) throws IllegalArgumentException {
    if (filter == null) {
      filter = new Filter();
    }

    filter.setPrefixRule(value);
  }

  /** sets filter suffix rule. */
  public void setSuffixRule(String value) throws IllegalArgumentException {
    if (filter == null) {
      filter = new Filter();
    }

    filter.setSuffixRule(value);
  }

  /** returns filter rule list. */
  public List<FilterRule> filterRuleList() {
    if (filter != null) {
      return filter.filterRuleList();
    }

    return null;
  }
}
