package com.jsolisg.vmaze_middelware.percistence.document;

import java.util.List;

public record ScheduleDocument(
        String time,
        List<String> days
) {
}
