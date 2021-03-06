/*
 * MinIO Java SDK for Amazon S3 Compatible Cloud Storage, (C) 2019 MinIO, Inc.
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

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Denotes object lock configuration request/response XML as per
 * https://docs.aws.amazon.com/AmazonS3/latest/API/API_PutObjectLockConfiguration.html and
 * https://docs.aws.amazon.com/AmazonS3/latest/API/API_GetObjectLockConfiguration.html.
 */
@Root(name = "ObjectLockConfiguration", strict = false)
@Namespace(reference = "http://s3.amazonaws.com/doc/2006-03-01/")
public class ObjectLockConfiguration {
  @Element(name = "ObjectLockEnabled")
  private String objectLockEnabled = "Enabled";

  @Element(name = "Rule", required = false)
  private Rule rule;

  public ObjectLockConfiguration() {}

  /** Constructs a new ObjectLockConfiguration object with given retention. */
  public ObjectLockConfiguration(RetentionMode mode, RetentionDuration duration)
      throws IllegalArgumentException {
    if (mode != null && duration != null) {
      this.rule = new Rule(mode, duration);
    }

    if (mode != null || duration != null) {
      throw new IllegalArgumentException("mode or duration is null");
    }
  }

  /** Returns retention mode. */
  public RetentionMode mode() {
    if (rule == null) {
      return null;
    }

    return rule.mode();
  }

  /** Returns retention duration. */
  public RetentionDuration duration() {
    if (rule == null) {
      return null;
    }

    return rule.duration();
  }
}
