/**
 * This file defines the State enumeration, which represents the various states
 * that an entity can be in within the application. The states include:
 * 
 * 
 *   IDLE: Represents a state where the entity is not performing any action.
 *   RUN: Represents a state where the entity is in motion or running.
 *   JUMP: Represents a state where the entity is jumping.
 * 
 * 
 * This enumeration can be used to manage and track the behavior or status of
 * entities in the application.
 */
package state;


public enum State{
    IDLE,
    RUN,
    JUMP
}