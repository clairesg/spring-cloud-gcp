/*
 * Copyright 2017-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.gcp.test;

/**
 * An interface that each emulator needs to implement so that it can be used with the {@link EmulatorDriver}.
 * @author Mike Eltsufin
 * @author Elena Felder
 * @author Dmitry Solomakha
 * @since 1.2.3
 */
public interface Emulator {

	/**
	 * The name of the emulator command in gcloud CLI.
	 */
	String getName();

	/**
	 * The list of command fragments that match the emulator processes to be killed.
	 * @param hostPort THe emulator host-port.
	 */
	String[] getKillCommandFragments(String hostPort);

	/**
	 * Custom kill commands that need to run to stop the emulator.
	 */
	default String[][] getPostKillCommands() {
		return new String[0][0];
	}

	/**
	 * Custom start commands that need after the emulator is started.
	 */
	default String[][] getPostStartCommands() {
		return new String[0][0];
	}

}