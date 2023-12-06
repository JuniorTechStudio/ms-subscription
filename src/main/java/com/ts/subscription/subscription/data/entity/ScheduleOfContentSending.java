package com.ts.subscription.subscription.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.scheduling.support.CronTrigger;

import java.util.UUID;

@Entity
@Table(schema = "subscription", name = "schedule_of_content_sending")
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleOfContentSending {

    @Id
    @SequenceGenerator(name="pk_sequence",sequenceName="subscription_sequence", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
    @Column(name = "id")
    private Integer id;

    @Column(name = "subscription_id")
    private UUID subscriptionId;

    @Column(name = "cron")
    private String cron;

    public CronTrigger getCronTrigger() {
        return new CronTrigger(this.cron);
    }

}
